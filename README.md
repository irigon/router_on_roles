# Build
=

`mvn compile exec:java`

## Goal

I have a simple java object (router) that is the player. 
Depending on the context, it may play different routing algorithms.

When two devices meet, for every stored message, a router activates a compartment that adapts the routing algorithm.
Next, it plays the role "route" and decides wether the message should be forwarded.
Then it gets the next stored message and starts over.

## Problem

When I activate a compartment, I pass the object router.
The adapt function is scala calls 

```
router play new AlgorithmA
```

At this point I have the following:

Router (plays) AlgorithmA

Next, if I adapt to algorithmB, I expected to have

Router (plays) AlgorithmB

But it seems that I get:

Router (plays) AlgorithmA (plays) AlgorithmB

Is it possible (other than using a singleton) that I want to exchange the role, instead of have a role plays role behavior?


Without cycles I am getting:

```
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ scroll-router ---
1.57141338E9 seconds to process the last 1000 role changes
0.289 seconds to process the last 1000 role changes
0.227 seconds to process the last 1000 role changes
0.242 seconds to process the last 1000 role changes
0.295 seconds to process the last 1000 role changes
0.368 seconds to process the last 1000 role changes
0.429 seconds to process the last 1000 role changes
0.53 seconds to process the last 1000 role changes
0.592 seconds to process the last 1000 role changes
0.716 seconds to process the last 1000 role changes
0.813 seconds to process the last 1000 role changes
0.857 seconds to process the last 1000 role changes
0.959 seconds to process the last 1000 role changes
1.139 seconds to process the last 1000 role changes
1.244 seconds to process the last 1000 role changes
```

Avoiding Cycles:

```
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ scroll-router ---
1.57141363E9 seconds to process the last 1000 role changes
0.415 seconds to process the last 1000 role changes
0.276 seconds to process the last 1000 role changes
0.318 seconds to process the last 1000 role changes
0.437 seconds to process the last 1000 role changes
0.541 seconds to process the last 1000 role changes
0.669 seconds to process the last 1000 role changes
0.834 seconds to process the last 1000 role changes
0.94 seconds to process the last 1000 role changes
1.059 seconds to process the last 1000 role changes
1.28 seconds to process the last 1000 role changes
1.389 seconds to process the last 1000 role changes
1.543 seconds to process the last 1000 role changes
1.747 seconds to process the last 1000 role changes
1.91 seconds to process the last 1000 role changes
```



