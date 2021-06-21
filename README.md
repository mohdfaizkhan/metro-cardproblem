# Metro CardProblem

The Metro Card Problem
You are required to model the following fare card system which is a limited version of
Metro card system. At the end of the application, you are be able to see a
user loading a card with $30, and taking the following trips, and then viewing the balance.
- Train Hamilton to Thunder Bay
- 106 bus from Thunder Bay to Dryden
- Train Dryden to Slate Falls

Operation
When the user passes through the inward barrier at the station, their metro card is charged the maximum fare.
When they pass out of the barrier at the exit station, the fare is calculated and the maximum
fare transaction removed and replaced with the real transaction (in this way, if the user
doesn’t swipe out, they are charged the maximum fare).

All bus journeys are charged at the same price.
The system should favor the customer where more than one fare is possible for a given journey. E.g.,
Hamilton to Thunder Bay is charged at $2.50.

For the purposes of this test use the following data:
Stations and zones:

Station      | Zone(s)
------------ | -------------
Hamilton  | 1
Thunder Bay  | 1, 2
Dryden | 3
Slate Falls  | 2

Fares:


Journey      | Fare
------------ | -------------
Anywhere in Zone 1 | $2.50
Any one zone outside zone 1 | $2.00
Any two zones including zone 1 | $3.00
Any two zones excluding zone 1 | $2.25
Any three zones | $3.20
Any bus journey | $1.80

The maximum possible fare is therefore $3.20.

Solution:

There are 2 entities - Card & Transaction

Due checkin you will be charged to maximum amount, due checkout refund amount will be calculated and update
card balance accordigly

either https://github.com/rulebook-rules/rulebook or https://github.com/kiegroup/drools will be implemented soon
