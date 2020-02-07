/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.iam.credentials.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest;
import com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse;
import com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest;
import com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse;
import com.google.cloud.iam.credentials.v1.IamCredentialsClient;
import com.google.cloud.iam.credentials.v1.SignBlobRequest;
import com.google.cloud.iam.credentials.v1.SignBlobResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static IamCredentialsClient client;
  private static String serviceAccount;

  private static final Logger LOGGER = Logger.getGlobal();
  private static final String GOOGLE_API_CLOUD_SCOPE =
      "https://www.googleapis.com/auth/cloud-platform";
  private static final Duration LIFE_TIME = Duration.newBuilder().setSeconds(3600).build();

  @BeforeClass
  public static void setUp() throws Exception {
    ServiceAccountCredentials credentials =
        (ServiceAccountCredentials) GoogleCredentials.getApplicationDefault();
    client = IamCredentialsClient.create();
    serviceAccount = credentials.getClientEmail();
    LOGGER.info("service-account:" + serviceAccount);
  }

  @AfterClass
  public static void tearDown() {
    client.close();
  }

  @Test
  public void generateAccessTokenTest() {
    GenerateAccessTokenRequest request =
        GenerateAccessTokenRequest.newBuilder()
            .setName(serviceAccount)
            .setLifetime(LIFE_TIME)
            .addScope(GOOGLE_API_CLOUD_SCOPE)
            .build();
    GenerateAccessTokenResponse accessToken = client.generateAccessToken(request);
    assertNotNull(accessToken);
    assertNotNull(accessToken.getAccessToken());
    assertNotNull(accessToken.getExpireTime());
    assertEquals(Boolean.TRUE, accessToken.getDefaultInstanceForType().isInitialized());
  }

  @Test
  public void generateIdTokenTest() {
    GenerateIdTokenRequest generateIdTokenRequest =
        GenerateIdTokenRequest.newBuilder()
            .setName(serviceAccount)
            .setAudience(serviceAccount)
            .setIncludeEmail(Boolean.FALSE)
            .build();
    GenerateIdTokenResponse idToken = client.generateIdToken(generateIdTokenRequest);
    assertNotNull(idToken);
    assertNotNull(idToken.getToken());
    assertEquals(Boolean.TRUE, idToken.isInitialized());
  }

  @Test
  public void signBlobTest() {
    ByteString payload = ByteString.copyFromUtf8("-114");
    SignBlobRequest signBlobRequest =
        SignBlobRequest.newBuilder().setName(serviceAccount).setPayload(payload).build();
    SignBlobResponse signBlob = client.signBlob(signBlobRequest);
    assertNotNull(signBlob);
    assertNotNull(signBlob.getKeyId());
    assertNotNull(signBlob.getSignedBlob());
    assertEquals(Boolean.TRUE, signBlob.isInitialized());
  }
}
