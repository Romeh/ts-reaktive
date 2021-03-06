package com.tradeshift.reaktive.marshal.http;

import akka.http.javadsl.marshalling.Marshaller;
import akka.http.javadsl.model.ContentType;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.RequestEntity;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

public class HttpStreamingMarshallers {
    /**
     * Returns a marshaller that renders a source of bytes into a response entity with the given [contentType].
     */
    public static final Marshaller<Source<ByteString,?>, RequestEntity> sourceToEntity(ContentType contentType) {
        return Marshaller.opaque((Source<ByteString,?> data) -> {
            return HttpEntities.createChunked(contentType, data);
        });
    }
}
