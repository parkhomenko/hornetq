/*
 * Copyright 2005-2014 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.hornetq.core.protocol.openwire.amq;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.Message;

public class AMQSharedDeadLetterStrategy extends AMQAbstractDeadLetterStrategy
{
   public static final String DEFAULT_DEAD_LETTER_QUEUE_NAME = "ActiveMQ.DLQ";

   private ActiveMQDestination deadLetterQueue = new ActiveMQQueue(
         DEFAULT_DEAD_LETTER_QUEUE_NAME);

   public ActiveMQDestination getDeadLetterQueueFor(Message message,
         AMQSubscription subscription)
   {
      return deadLetterQueue;
   }

   public ActiveMQDestination getDeadLetterQueue()
   {
      return deadLetterQueue;
   }

   public void setDeadLetterQueue(ActiveMQDestination deadLetterQueue)
   {
      this.deadLetterQueue = deadLetterQueue;
   }

   @Override
   public boolean isDLQ(ActiveMQDestination destination)
   {
      if (destination.equals(deadLetterQueue))
      {
         return true;
      }
      else
      {
         return false;
      }
   }

}
