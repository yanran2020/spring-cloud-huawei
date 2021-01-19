/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaweicloud.governance;

import java.io.IOException;
import java.util.List;

import org.apache.servicecomb.governance.handler.ext.RetryExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpServerErrorException;

import feign.Response;

public class SpringCloudRetryExtension implements RetryExtension {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudRetryExtension.class);

  @Override
  public boolean isRetry(List<Integer> statusList, Object response) {
    int status = 0;
    if (response instanceof ClientHttpResponse) {
      try {
        status = ((ClientHttpResponse) response).getStatusCode().value();
      } catch (IOException e) {
        LOGGER.error("unexpected exception", e);
      }
    }
    if (response instanceof Response) {
      status = ((Response) response).status();
    }
    return statusList.contains(status);
  }

  @Override
  public Class<? extends Throwable>[] retryExceptions() {
    return new Class[] {HttpServerErrorException.class};
  }
}