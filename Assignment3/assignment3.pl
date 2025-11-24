% =========================================
% Question 1 – Family Tree
% =========================================

wife(kydd, mum).
wife(elizabeth, philip).
wife(margaret, snowdon).
wife(diana, charles).
wife(anne, mark).
wife(sarah, andrew).

son(charles, elizabeth).
son(andrew, elizabeth).
son(edward, elizabeth).
son(william, diana).
son(harry, diana).
son(peter, anne).

daughter(anne, elizabeth).
daughter(beatrice, sarah).
daughter(eugenie, sarah).
daughter(zara, anne).

husband(H, W) :- wife(W, H).

spouse(X, Y) :- wife(X, Y).
spouse(X, Y) :- husband(X, Y).

child(C, P) :- son(C, P).
child(C, P) :- daughter(C, P).

parent(P, C) :- child(C, P).
parent(P, C) :- spouse(P, S), child(C, S).


grandChild(G, P) :- parent(X, G), parent(P, X).

greatGrandParent(GG, C) :-
    parent(GG, X),
    parent(X, Y),
    parent(Y, C).



brother(B, S) :- son(B, P), child(S, P), B \= S.
sister(S, Sib) :- daughter(S, P), child(Sib, P), S \= Sib.

sibling(X, Y) :- brother(X, Y).
sibling(X, Y) :- sister(X, Y).

uncle(U, N) :- brother(U, P), parent(P, N).
uncle(U, N) :- spouse(U, A), sister(A, P), parent(P, N).

aunt(A, N) :- sister(A, P), parent(P, N).
aunt(A, N) :- spouse(A, U), brother(U, P), parent(P, N).

brotherInLaw(B, X) :- spouse(X, S), brother(B, S).
brotherInLaw(B, X) :- spouse(B, S), sister(S, X).

sisterInLaw(S, X) :-
    wife(S, Y),
    brother(Y, X),
    S \= X.

sisterInLaw(S, X) :-
    sister(S, Y),
    spouse(Y, X),
    S \= X.



firstCousin(X, Y) :-
    parent(P1, X),
    parent(P2, Y),
    sibling(P1, P2),
    X \= Y.

% =========================================
% Question 2 – Dating Rules
% =========================================

person(lily, female, 180, 30, phd).
person(jenny, female, 167, 25, hs).
person(bob, male, 180, 40, phd).
person(richard, male, 190, 30, masters).
person(tom, male, 177, 29, hs).

degree_lower(hs, bs).
degree_lower(bs, ms).
degree_lower(ms, phd).

dateable(F, M) :-
    person(F, female, HF, AF, EF),
    person(M, male, HM, AM, EM),
    HM >= HF,
    degree_lower(EF, EM),
    AM >= AF,
    Diff is AM - AF,
    Diff =< 10.



