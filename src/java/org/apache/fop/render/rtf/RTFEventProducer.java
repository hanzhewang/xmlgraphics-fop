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

package org.apache.fop.render.rtf;

import org.xml.sax.Locator;

import org.apache.fop.events.EventBroadcaster;
import org.apache.fop.events.EventProducer;
import org.apache.fop.events.model.AbstractEventModelFactory;
import org.apache.fop.events.model.EventModel;
import org.apache.fop.fo.FONode;

/**
 * Event producer interface for events generated by the RTF renderer.
 */
public interface RTFEventProducer extends EventProducer {

    /** Provider class for the event producer. */
    class Provider {

        /**
         * Returns an event producer.
         * @param broadcaster the event broadcaster to use
         * @return the event producer
         */
        public static RTFEventProducer get(EventBroadcaster broadcaster) {
            return (RTFEventProducer)broadcaster.getEventProducerFor(
                    RTFEventProducer.class);
        }
    }

    /** Event model factory for this event producer. */
    public static class EventModelFactory extends AbstractEventModelFactory {

        /** {@inheritDoc} */
        public EventModel createEventModel() {
            return loadModel(getClass(), "event-model.xml");
        }

    }

    /**
     * The RTF handler only supports simple-page-masters.
     * @param source the event source
     * @param masterReference the reference page-master-set
     * @param loc the location of the error or null
     * @event.severity WARN
     */
    void onlySPMSupported(Object source, String masterReference, Locator loc);

    /**
     * No simple-page-master could be determined-
     * @param source the event source
     * @param loc the location of the error or null
     * @event.severity WARN
     */
    void noSPMFound(Object source, Locator loc);

    /**
     * The RTF handler requires explicit table-columns for now.
     * @param source the event source
     * @param loc the location of the error or null
     * @event.severity WARN
     */
    void explicitTableColumnsRequired(Object source, Locator loc);

    /**
     * The RTF handler ignored some deferred event (i.e. an unsupported element).
     * @param source the event source
     * @param node the FO tree node being ignored
     * @param start true for start, false for end
     * @param loc the location of the error or null
     * @event.severity WARN
     */
    void ignoredDeferredEvent(Object source, FONode node, boolean start, Locator loc);

}
