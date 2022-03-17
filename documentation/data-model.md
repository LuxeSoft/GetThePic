# E-R Relationship in Data Base structure

![taulesBBDD](https://user-images.githubusercontent.com/83337658/158844526-e0bba45a-b645-4461-8b6b-1a663727be37.png)

# Comentant l'estructura:
**- Taula Partides:** la taula Partides va connectada a Players, ja que en una partida només pot haver-hi un jugador. També va connectada a Imatges, ja que en una partida només pot haver-hi una imatge (cada partida té una imatge diferent). També està connectada a la taula Cards ja que en una partida hi han diferents cartes (en concret, 8 cartes).

**- Taula Players:** la taula Players va connectada a Partides, ja que un jugador pot jugar a diferents partides. També va connectada a Players_Tokens perquè és un codi identificatiu del player.

**- Taula Players_Tokens:** la taula Players_Tokens va connectada a Players perquè és un codi identificatiu del player.

**- Taula Imatges:** la taula Imatges va connectada a Partides, ja que una imatge només pot estar en una partida (cada partida té una imatge diferent).

**- Taula Cards:** la taula Cards va connectada a Partides, ja que una carta pot estar en diferents partides.

**- Taula posició:** la taula Posició surt de la relació n a n entre la taula Partides i Cards.

Sobre el **Ranking Global**, hem decidit que per mostrar-lo farem una suma amb GROUP BY de tots els _score_ de tots els **Players**.


# Pas a taules:

PARTIDES(**id_partida**, _username_, score, temps, guanyat)

PLAYERS(**username**, password, pic_coins, wins, xp)

CARDS(**letter**, imatge_lletra)

IMATGES(**nom_imatge**, imatge_nivell)

posició(**id_partida**, **letter**)

PLAYERS_TOKENS(**tokens**, _username_)
