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
spouse(X, Y) :- wife(X, Y); husband(X, Y).
spouse(Y, X) :- spouse(X, Y).

child(C, P) :- son(C, P); daughter(C, P).
parent(P, C) :- child(C, P).

grandChild(G, P) :- parent(X, G), parent(P, X).
greatGrandParent(GG, C) :- parent(GG, P), grandChild(C, P).

brother(B, S) :- son(B, P), parent(P, S), B \= S.
sister(S, Sib) :- daughter(S, P), parent(P, Sib), S \= Sib.

uncle(U, N) :- brother(U, P), parent(P, N).
aunt(A, N) :- sister(A, P), parent(P, N).

brotherInLaw(B, X) :-
    husband(B, Y), sister(Y, X);
    husband(B, Y), spouse(X, Y);
    brother(B, Y), spouse(Y, X).

sisterInLaw(S, X) :-
    wife(S, Y), brother(Y, X);
    wife(S, Y), spouse(X, Y);
    sister(S, Y), spouse(Y, X).

firstCousin(X, Y) :-
    parent(P1, X), parent(P2, Y), brother(P1, P2);
    parent(P1, X), parent(P2, Y), sister(P1, P2), X \= Y.

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
degree_lower(D, D).
degree_lower(A, C) :- degree_lower(A, B), degree_lower(B, C).

dateable(F, M) :-
    person(F, female, HF, AF, EF),
    person(M, male, HM, AM, EM),
    HM >= HF,
    degree_lower(EF, EM),
    AM >= AF,
    (AM - AF) =< 10.
