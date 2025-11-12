% assignment3.pl
% Family relationships and dating eligibility

% --- Facts ---
wife(sarah, andrew).
wife(elizabeth, philip).
wife(diana, charles).
wife(kate, william).
wife(meghan, harry).
wife(eugenie, jack).
wife(beatrice, edoardo).

parent(elizabeth, charles).
parent(elizabeth, andrew).
parent(elizabeth, anne).
parent(charles, william).
parent(charles, harry).
parent(andrew, beatrice).
parent(andrew, eugenie).
parent(william, george).
parent(william, charlotte).
parent(william, louis).
parent(harry, archie).
parent(harry, lilibet).
parent(anne, zara).
parent(anne, peter).

female(elizabeth).
female(sarah).
female(diana).
female(kate).
female(meghan).
female(eugenie).
female(beatrice).
female(charlotte).
female(anne).
female(zara).
female(lilibet).
female(jenny).
female(lily).

male(tom).
male(philip).
male(andrew).
male(charles).
male(william).
male(harry).
male(george).
male(archie).
male(peter).
male(jack).
male(edoardo).
male(bob).
male(richard).



% --- Rules ---
husband(H, W) :- wife(W, H).

child(C, P) :- parent(P, C).
grandParent(GP, GC) :- parent(GP, X), parent(X, GC).
grandChild(GC, GP) :- grandParent(GP, GC).
greatGrandParent(GGP, GGC) :- parent(GGP, GP), grandParent(GP, GGC).

sisterInLaw(S, X) :-
    wife(S, B),
    brother(B, H),
    wife(X, H).
sisterInLaw(S, X) :-
    brother(H, X),
    wife(S, H).
sisterInLaw(S, X) :-
    wife(X, H),
    brother(H, B),
    wife(S, B).

brother(B, X) :- male(B), parent(P, B), parent(P, X), B \= X.
uncle(U, N) :- brother(U, P), parent(P, N).

% --- Education hierarchy ---
degree_lower(hs, ug).
degree_lower(ug, ms).
degree_lower(ms, phd).

degree_lower(X, Z) :- degree_lower(X, Y), degree_lower(Y, Z).

% --- Dating rules ---
older(X, Y) :- male(X), female(Y). % Dummy condition for demo
dateable(X, Y) :- male(X), female(Y), X \= Y.
dateable(X, Y) :- female(X), male(Y), X \= Y.