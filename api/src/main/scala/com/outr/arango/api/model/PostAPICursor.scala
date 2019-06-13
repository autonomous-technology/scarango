package com.outr.arango.api.model

import io.circe.Json

/**
  * PostAPICursor
  *
  * @param query contains the query string to be executed
  * @param batchSize maximum number of result documents to be transferred from
  *        the server to the client in one roundtrip. If this attribute is
  *        not set, a server-controlled default value will be used. A *batchSize* value of
  *        *0* is disallowed.
  * @param bindVars key/value pairs representing the bind parameters.
  * @param cache flag to determine whether the AQL query results cache
  *        shall be used. If set to *false*, then any query cache lookup will be skipped
  *        for the query. If set to *true*, it will lead to the query cache being checked
  *        for the query if the query cache mode is either *on* or *demand*.
  * @param count indicates whether the number of documents in the result set should be returned in
  *        the "count" attribute of the result.
  *        Calculating the "count" attribute might have a performance impact for some queries
  *        in the future so this option is turned off by default, and "count"
  *        is only returned when requested.
  * @param memoryLimit the maximum number of memory (measured in bytes) that the query is allowed to
  *        use. If set, then the query will fail with error "resource limit exceeded" in
  *        case it allocates too much memory. A value of *0* indicates that there is no
  *        memory limit.
  * @param options *** No description ***
  * @param ttl The time-to-live for the cursor (in seconds). The cursor will be
  *        removed on the server automatically after the specified amount of time. This
  *        is useful to ensure garbage collection of cursors that are not fully fetched
  *        by clients. If not set, a server-defined value will be used (default: 30 seconds).
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PostAPICursor(query: String,
                         batchSize: Option[Long] = None,
                         bindVars: Json,
                         cache: Option[Boolean] = None,
                         count: Option[Boolean] = None,
                         memoryLimit: Option[Long] = None,
                         options: Option[PostAPICursorOpts] = None,
                         ttl: Option[Long] = None)