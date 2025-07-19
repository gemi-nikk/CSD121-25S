Why can we return different player types from promptForPlayer() without changing the return type?
Because all the different types of players like Human, Linus, Randy are basically extensions of the same base class: Player. Since they all inherit from Player, Java is cool with the method just saying it returns a Player. Behind the scenes, it might be returning a LinusPlayer or HumanPlayer, but the code doesn’t care as long as it’s a Player, it works. That’s the magic of polymorphism.

Why did the error happen, and how does making the method abstract fix it?
The error came up because we removed the pickNextMove() method from the Player class, but the rest of the program was still trying to call it. Java freaks out because it doesn’t know if all Player objects actually have that method anymore.
So we fix it by making the method abstract in the Player class. That’s like telling Java, “Chill, I promise all subclasses will implement this.” That makes the compiler happy, and the game runs fine again.

Why didn’t we have to change TicTacToeGame or Main when we added new players?
This part was honestly pretty cool. didn’t have to touch the game logic at all because everything runs through the Player class. Once we added a new type of player and made sure they had the required method, the game just knew how to use them.
This is all thanks to abstraction and polymorphism the game doesn’t need to know the details about each player. It just trusts that any Player knows how to take a turn. That made it super easy to add new AIs without rewriting anything in the main code.