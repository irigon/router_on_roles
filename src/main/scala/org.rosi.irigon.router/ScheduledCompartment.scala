package org.rosi.irigon.router;

import scroll.internal._
import scroll.internal.support.DispatchQuery
import DispatchQuery._

class ScheduledCompartment extends AbstractCompartment {

    def compartment_name() : String = { "Scheduled Compartment" }

    class ScheduledAlgorithm{
        def algo_name() : String = { "ScheduledAlgorithm A" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    class AlgorithmBRouter {
        def algo_name() : String = { "Algorithm B" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    def adapt(router : AbstractRouter, info: String) : Player[AbstractRouter] = {
        router play new ScheduledAlgorithm
    }

    def route(router : Player[AbstractRouter], msg : String) : String = {
        router route msg
    }
}