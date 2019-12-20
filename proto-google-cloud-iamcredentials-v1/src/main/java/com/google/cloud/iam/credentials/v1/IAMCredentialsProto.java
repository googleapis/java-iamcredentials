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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/iam/credentials/v1/iamcredentials.proto

package com.google.cloud.iam.credentials.v1;

public final class IAMCredentialsProto {
  private IAMCredentialsProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n.google/iam/credentials/v1/iamcredentia"
          + "ls.proto\022\031google.iam.credentials.v1\032\034goo"
          + "gle/api/annotations.proto\032\027google/api/cl"
          + "ient.proto\032&google/iam/credentials/v1/co"
          + "mmon.proto2\255\007\n\016IAMCredentials\022\354\001\n\023Genera"
          + "teAccessToken\0225.google.iam.credentials.v"
          + "1.GenerateAccessTokenRequest\0326.google.ia"
          + "m.credentials.v1.GenerateAccessTokenResp"
          + "onse\"f\202\323\344\223\002@\";/v1/{name=projects/*/servi"
          + "ceAccounts/*}:generateAccessToken:\001*\332A\035n"
          + "ame,delegates,scope,lifetime\022\344\001\n\017Generat"
          + "eIdToken\0221.google.iam.credentials.v1.Gen"
          + "erateIdTokenRequest\0322.google.iam.credent"
          + "ials.v1.GenerateIdTokenResponse\"j\202\323\344\223\002<\""
          + "7/v1/{name=projects/*/serviceAccounts/*}"
          + ":generateIdToken:\001*\332A%name,delegates,aud"
          + "ience,include_email\022\271\001\n\010SignBlob\022*.googl"
          + "e.iam.credentials.v1.SignBlobRequest\032+.g"
          + "oogle.iam.credentials.v1.SignBlobRespons"
          + "e\"T\202\323\344\223\0025\"0/v1/{name=projects/*/serviceA"
          + "ccounts/*}:signBlob:\001*\332A\026name,delegates,"
          + "payload\022\265\001\n\007SignJwt\022).google.iam.credent"
          + "ials.v1.SignJwtRequest\032*.google.iam.cred"
          + "entials.v1.SignJwtResponse\"S\202\323\344\223\0024\"//v1/"
          + "{name=projects/*/serviceAccounts/*}:sign"
          + "Jwt:\001*\332A\026name,delegates,payload\032Q\312A\035iamc"
          + "redentials.googleapis.com\322A.https://www."
          + "googleapis.com/auth/cloud-platformB\205\001\n#c"
          + "om.google.cloud.iam.credentials.v1B\023IAMC"
          + "redentialsProtoP\001ZDgoogle.golang.org/gen"
          + "proto/googleapis/iam/credentials/v1;cred"
          + "entials\370\001\001b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.cloud.iam.credentials.v1.IAMCredentialsCommonProto.getDescriptor(),
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.cloud.iam.credentials.v1.IAMCredentialsCommonProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
