# ENSAI-2A-Java-TP
Martin GLUMINEAU & Claire ROBIN

### 2.1 : Simulation setup
##### 2.1.1 : 
modification de la probabilité dans application.yml

##### 2.1.2 : 
ajout de "quantity" et "floors/number" dans application.yml. Ajout boucles dans le main pour définir les étages et les ascenceurs.

##### 2.1.3 :
ajout d'un Config.getInt pour récupérer le nombre d'étages

##### 2.1.4 & 2.1.5 :
implémentation de isFull() dans Elevator.java, et utilisation de la nouvelle méthode dans loadPassengers

### 2.2 : Request an elevator
Modification de la méthode requestElevator dans Floor.java
On ajoute Isontheway pour vérifier si un ascenseur est déjà en route auquel cas appuyer sur le bouton ne fait rien, sinon l'ascenceur avec la plus petite liste de destination est envoyé.

### 2.3 : target floor
Modification de la méthode generateTargetFloor() dans Person.java : on sélectionne un floor random parmi les étages où on ne se trouve pas.

### 2.4 : Unit test
##### 2.4.1 :
Il est difficile de tester la méthode isFull() car la capacité de l'ascenceur est modulable. SI on augmente la capacité de l'ascenceur, il peut être difficile de tester le cas 'true', car il faudrait instancier un grand nombre de Personnes pour tester ce cas, personnes qui doivent avoir un étage de départ. Le test, une fois écrit, ne s'adapte pas à la capacité modulable de l'ascenceur.

##### 2.4.2 :
réalisation d'un teste pour la fonction isFull : 
vérifie que l'ascenseur n'est pas remplie quand il est vide et qu'il est plein une fois qu'il atteint sa capacité maximum

##### 2.4.3 :

Teste la fonction addDestination : 
vérifie que l'ascenseur ajoute correctement une nouvelle destination


### 2.5 : Crazy Elevator
##### 2.5.1 :
Classe Crazy Elevator créée, qui hérite de la classe Elevator.

##### 2.5.2 :
Override de la méthode move() de Elevator pour implémenter les trois cas.

##### 2.5.3 :
Override de la méthode unloadPassengers(Floor floor).

##### 2.5.4 :
Override de la méthode isFull().

##### 2.5.5 :
Ajout d'un paramètre "crazy-elevator/quantity" au fichier application.yml.
Ajout du crazy elevator dans la liste des ascenceurs de l'hotel dans le Main.java.

### 2.6 : Elevator Direction
##### 2.6.1 :
On définit l'attribut direction comme un enum : il définit les 3 cas possibles (up/down/idle). Il est créé dans le fichier Direction.java.
On l'ajoute aux paramètres de Person, Elevator et on l'étend à CrazyElevator. On ajoute des getter (getDirection) à Person et Elevator.
Dans le constructeur de Elevator, on initialise l'attribut direction à "idle". Dans le constructeur de Person, on compare le target floor et le start floor pour déterminer le statut up/down.

##### 2.6.2 :
On met à jour la direction dans la méthode move() de Elevator (et du cas du comportement normal de move() de CrazyElevator).

##### Bonus :
On créée une méthode getArrow dans Direction.java
On ajoute la flèche dans le display de Hotel.java dans la ligne où on print "Elevator".
