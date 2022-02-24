package com.bfi.bravo.utils;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Value;

public final class StorageUtil {

  @Value("${google.cloud.storage.url}")
  private static String googleCloudStorageUrl;

  @Value("${google.cloud.storage.bucket-name}")
  private static String googleCloudStorageBucketName;

  public static String getFilePath(String storageObject) {
    try {
      return String.format(
        "%s/%s/%s",
        googleCloudStorageUrl,
        googleCloudStorageBucketName,
        URLEncoder.encode(storageObject, UTF_8.toString())
      );
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }
}
