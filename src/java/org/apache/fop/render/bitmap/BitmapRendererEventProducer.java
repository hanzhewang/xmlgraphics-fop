/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.bitmap;

import java.io.IOException;

import org.apache.fop.events.EventBroadcaster;
import org.apache.fop.events.EventProducer;

/**
 * Event producer interface for events generated by the bitmap renderers.
 */
public interface BitmapRendererEventProducer extends EventProducer {

    /** Provider class for the event producer. */
    class Provider {

        /**
         * Returns an event producer.
         * @param broadcaster the event broadcaster to use
         * @return the event producer
         */
        public static BitmapRendererEventProducer get(EventBroadcaster broadcaster) {
            return (BitmapRendererEventProducer)broadcaster.getEventProducerFor(
                    BitmapRendererEventProducer.class);
        }
    }

    /**
     * No filename information available. Stopping early after the first page.
     * @param source the event source
     * @event.severity WARN
     */
    void stoppingAfterFirstPageNoFilename(Object source);

    /**
     * Image writer does not support multiple images. Only the first page has been produced.
     * @param source the event source
     * @event.severity WARN
     */
    void stoppingAfterFirstPageNoMultiWriter(Object source);

    /**
     * No ImageWriter found.
     * @param source the event source
     * @param mime the target MIME type
     * @throws IOException the I/O error provoked by the method call
     * @event.severity FATAL
     */
    void noImageWriterFound(Object source, String mime) throws IOException;
}
