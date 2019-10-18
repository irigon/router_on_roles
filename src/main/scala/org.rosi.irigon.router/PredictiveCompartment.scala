package org.rosi.irigon.router

import scroll.internal._

class PredictiveCompartment extends AbstractCompartment {

    def compartment_name() : String = { "Predictive Compartment" }

    class AlgorithmARouter {
        def algo_name() : String = { "PredictiveAlgorithm A" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    class PredictiveAlgorithmB{
        def algo_name() : String = { "PredictiveAlgorithm B" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    def adapt(router : AbstractRouter, info: String) : Player[AbstractRouter] = {
         router play new PredictiveAlgorithmB
    }

    def route(router : Player[AbstractRouter], msg : String) : String = {
        router route msg
    }
}