package org.rosi.irigon.router

import scroll.internal._

class NaiveCompartment extends AbstractCompartment{

    def compartment_name() : String = { "Naive Compartment" }

    class NaiveAlgorithmB {
        def algo_name() : String = { "Algorithm A" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    class NaiveAlgorithmA {
        def algo_name() : String = { "NaiveAlgorithm X" }
        def route(msg : String) : String = {
            "Routing " + msg + " with " + algo_name() + " in " + compartment_name();
        }
    }

    def adapt(router : AbstractRouter, ctxt: String) : Player[AbstractRouter] = {
         router play new NaiveAlgorithmA
    }

    def route(router : Player[AbstractRouter], msg : String) : String = {
        router route msg
    }
}