/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.iam.credentials.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class IamCredentialsClientTest {
  private static MockIAMCredentials mockIAMCredentials;
  private static MockServiceHelper serviceHelper;
  private IamCredentialsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockIAMCredentials = new MockIAMCredentials();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIAMCredentials));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    IamCredentialsSettings settings =
        IamCredentialsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IamCredentialsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void generateAccessTokenTest() {
    String accessToken = "accessToken-1938933922";
    GenerateAccessTokenResponse expectedResponse =
        GenerateAccessTokenResponse.newBuilder().setAccessToken(accessToken).build();
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    List<String> scope = new ArrayList<>();
    Duration lifetime = Duration.newBuilder().build();

    GenerateAccessTokenResponse actualResponse =
        client.generateAccessToken(name, delegates, scope, lifetime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAccessTokenRequest actualRequest = (GenerateAccessTokenRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceAccountName.parse(actualRequest.getName()));
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(scope, actualRequest.getScopeList());
    Assert.assertEquals(lifetime, actualRequest.getLifetime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void generateAccessTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      List<String> scope = new ArrayList<>();
      Duration lifetime = Duration.newBuilder().build();

      client.generateAccessToken(name, delegates, scope, lifetime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void generateIdTokenTest() {
    String token = "token110541305";
    GenerateIdTokenResponse expectedResponse =
        GenerateIdTokenResponse.newBuilder().setToken(token).build();
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String audience = "audience975628804";
    boolean includeEmail = false;

    GenerateIdTokenResponse actualResponse =
        client.generateIdToken(name, delegates, audience, includeEmail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateIdTokenRequest actualRequest = (GenerateIdTokenRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceAccountName.parse(actualRequest.getName()));
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(audience, actualRequest.getAudience());
    Assert.assertEquals(includeEmail, actualRequest.getIncludeEmail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void generateIdTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      String audience = "audience975628804";
      boolean includeEmail = false;

      client.generateIdToken(name, delegates, audience, includeEmail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void signBlobTest() {
    String keyId = "keyId-1134673157";
    ByteString signedBlob = ByteString.copyFromUtf8("-32");
    SignBlobResponse expectedResponse =
        SignBlobResponse.newBuilder().setKeyId(keyId).setSignedBlob(signedBlob).build();
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    ByteString payload = ByteString.copyFromUtf8("-114");

    SignBlobResponse actualResponse = client.signBlob(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignBlobRequest actualRequest = (SignBlobRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceAccountName.parse(actualRequest.getName()));
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void signBlobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      ByteString payload = ByteString.copyFromUtf8("-114");

      client.signBlob(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void signJwtTest() {
    String keyId = "keyId-1134673157";
    String signedJwt = "signedJwt-979546844";
    SignJwtResponse expectedResponse =
        SignJwtResponse.newBuilder().setKeyId(keyId).setSignedJwt(signedJwt).build();
    mockIAMCredentials.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    List<String> delegates = new ArrayList<>();
    String payload = "-114";

    SignJwtResponse actualResponse = client.signJwt(name, delegates, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMCredentials.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SignJwtRequest actualRequest = (SignJwtRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceAccountName.parse(actualRequest.getName()));
    Assert.assertEquals(delegates, actualRequest.getDelegatesList());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void signJwtExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockIAMCredentials.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
      List<String> delegates = new ArrayList<>();
      String payload = "-114";

      client.signJwt(name, delegates, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
