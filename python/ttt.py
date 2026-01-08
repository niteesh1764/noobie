class Player: 
    def __init__( self, name, marker):
        self.name = name
        self.marker = marker
        
class Board: 
    def __init__(self, size) :
        self.reset(size)


    def reset(self, size): 
        self.board = [['' for x in range(size)] .copy() for y in range(size)]
        self.size = size
        self.rowCount = {}
        self.colCount = {}
        self.diagCount = {}


    def place(self,player,x,y):
        marker = player.marker
        if x >= self.size or y >= self.size :
            raise ValueError 

        if self.board[x][y] != '' :
            raise ValueError 
        else:
            self.board[x][y] = marker
            self.rowCount[x] = self.rowCount.get(x , {}) 
            self.rowCount[x][marker] = self.rowCount[x].get(marker,0) +1
            if self.rowCount[x][marker] == self.size :
                return True
            self.colCount[y] = self.colCount.get(y,{})
            self.colCount[y][marker] = self.colCount[y].get(marker,0) +1
            if self.colCount[y][marker] == self.size :
                return True
            if x==y: 
                self.diagCount["forwards"] = self.diagCount.get("forwards", {})
                self.diagCount["forwards"][marker] = self.diagCount["forwards"].get(marker,0) + 1
                if self.diagCount["forwards"][marker] == self.size:
                    return True
            if x+y == self.size-1:
                self.diagCount["backwards"] = self.diagCount.get("backwards",{}) 
                self.diagCount["backwards"][marker] = self.diagCount["backwards"].get(marker,0) +1
                if self.diagCount["backwards"][marker] == self.size : 
                    return True
        return False


class Game:
    def __init__ (self, player1, player2, board): 
        self.player1  = player1
        self.player2 = player2
        self.board = board
    def start(self) :
        currTurn = 1
        over = False;
        while not over: 
            currPlayer = self.player1 if currTurn%2 == 1 else self.player2
            print(currPlayer.name)
            x = int(input("X Position: \n"))
            y = int(input("Y Position: \n"))
            if self.board.place(currPlayer, x, y) :
                over = True
                print(f"{currPlayer.name} wins")
            else :
                currTurn+=1


niteesh = Player('niteesh', 'x') 
vijay = Player ('vijay', 'o') 

board = Board(3) 
game = Game(niteesh, vijay, board) 
game.start()


