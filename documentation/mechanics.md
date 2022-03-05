# MECHANICS

- Hi ha 3 modes: **normal, multijugador i contrarellotge**.

## Mode normal:
- Surt una pantalla amb tots els mons, on es van desbloquejant a mesura que superem els nivells.
- A l'entrar a un món es mostra la pantalla dels nivells d'aquell món.
- A l'entrar a un nivell comença la partida, apareix una imatge d'un objecte i a sota unes cartes amb lletres que es mostren durant uns segons, 
   a sota de les lletres hi ha uns comodins que el jugador pot utilitzar gastant monedes per ajudar-lo a completar el nivell.
- Després d'uns segons totes les cartes es giren i el jugador comença a pensar quina paraula identifica l'objecte de la imatge per polsar les 
   lletres en ordre.
- Si el jugador s'equivoca polsant una lletra, el progrés de la paraula s'esborra, totes les cartes es mostren durant uns segons i torna a començar.
- Si el jugador arriba a completar la paraula completa guanya el nivell, i com a recompensa guanya unes monedes.

## Mode multijugador:
- La mecànica del joc és com el mode normal només que pots jugar amb una altra persona i competir per a veure qui pot completar la paraula primer. Els usuaris podran veure, en temps real, el seu progres vs el del rival
- El guanyador de la partida se li recompensarà amb unes monedes (o XP), i al perdedor, li restaran monedes (o XP).
- No haura comodins

## Mode contrarellotge:
- La mecànica del joc és com el mode normal només que el jugador té un temps limitat per a completar el nivell.
- Si aconsegueix completar el nivell abans que s'acabi el temps guanya unes monedes.
- No haura comodins

## Altres funcions:
- Tenda: a la tenda el jugador podrà comprar amb diners reals monedes del joc.
- Configuració: per treure/activar els efectes de so i música, per canviar l'idioma i altres configuracions.

## Aclaració de mecàniques:
- Degut a que no tindria cap sentit la seva incorporació, hem optat per no posar IA ni possiblitat de jugar vs la màquina (acordat amb els professors de l'assignatura)
- Tampoc disposarem de jugabilitat per torns, ja que no es la dinamica que ha d'adoptar el nostre joc. L'usuari ha de anar jugant fins que completi el nivell o vulgui sortir. 
- Hem fet testing per comprovar que la funció de `comprovarParaula` funcioni correctament
- la condició de victoria sera que l'usuari completi el nivell i, per tant, se li sumi XP
