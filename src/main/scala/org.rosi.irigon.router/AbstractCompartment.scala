package org.rosi.irigon.router

import scroll.internal._

abstract class AbstractCompartment extends Compartment {
    def adapt(router : AbstractRouter, info: String) : Player[AbstractRouter];
    def route(router : Player[AbstractRouter], msg : String) : String ;
}