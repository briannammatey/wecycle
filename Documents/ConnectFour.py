#Board Class
class Board:
    """a data type for a Connect Four board with arbitrary dimensions"""

    def __init__(self, height, width):
        self.height = height
        self.width = width
        self.slots = [[' ']*self.width for _ in range(self.height)]

    def __repr__(self):
        """Returns a string that represents a Board object."""
        s = ''  # begin with an empty string

        # add one row of slots at a time to s
        for row in range(self.height):
            s += '|'  # one vertical bar at the start of the row
            for col in range(self.width):
                s += self.slots[row][col] + '|'
            s += '\n'  # newline at the end of the row

        s += '-' * (self.width * 2 + 1)
        s += '\n'
        num = 0
        for column in range(self.width):
            s += ' ' + str(num % 10)
            num += 1
        return s

    def add_checker(self, checker, col):
        """Adds the specified checker (either 'X' or 'O') to the
        column with the specified index col in the called Board.
        inputs: checker is either 'X' or 'O'
                col is a valid column index
        """
        assert checker == 'X' or checker == 'O'
        assert 0 <= col < self.width

        for row in range(self.height-1, -1, -1):
            if self.slots[row][col] == ' ':
                self.slots[row][col] = checker
                return

    def reset(self):
        """Resets the board so that the board is empty."""
        for row in range(self.height):
            for col in range(self.width):
                self.slots[row][col] = ' '

    def add_checkers(self, colnums):
        """Takes a string of column numbers and places alternating
        checkers in those columns of the called Board object,
        starting with 'X'.
        input: colnums is a string of valid column numbers
        """
        checker = 'X'  # start by playing 'X'

        for col_str in colnums:
            col = int(col_str)
            if 0 <= col < self.width:
                self.add_checker(checker, col)

            if checker == 'X':
                checker = 'O'
            else:
                checker = 'X'

    def can_add_to(self, col):
        """Returns True if it is valid to place a checker in the column col on the Board. 
        Otherwise, returns False."""
        return self.slots[0][col] == ' '

    def is_full(self):
        """Returns True if the Board is completely full of checkers, and False otherwise."""
        for col in range(self.width):
            if self.can_add_to(col):
                return False
        return True

    def remove_checker(self, col):
        """Removes the top checker from column col. If the column is empty, does nothing."""
        for row in range(self.height):
            if self.slots[row][col] != ' ':
                self.slots[row][col] = ' '
                return

    def is_win_for(self, checker):
        """Checks for a win for the specified checker."""
        assert checker == 'X' or checker == 'O'

        if self.is_horizontal_win(checker):
            return True
        elif self.is_vertical_win(checker):
            return True
        elif self.is_up_diagonal_win(checker):
            return True
        elif self.is_down_diagonal_win(checker):
            return True
        else:
            return False

    def is_horizontal_win(self, checker):
        """Checks for a horizontal win for the specified checker."""
        for row in range(self.height):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row][col + 1] == checker and \
                   self.slots[row][col + 2] == checker and \
                   self.slots[row][col + 3] == checker:
                    return True
        return False

    def is_vertical_win(self, checker):
        """Checks for a vertical win for the specified checker."""
        for row in range(self.height - 3):
            for col in range(self.width):
                if self.slots[row][col] == checker and \
                   self.slots[row + 1][col] == checker and \
                   self.slots[row + 2][col] == checker and \
                   self.slots[row + 3][col] == checker:
                    return True
        return False

    def is_down_diagonal_win(self, checker):
        """Checks for a downward diagonal win for the specified checker."""
        for row in range(self.height - 3):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row + 1][col + 1] == checker and \
                   self.slots[row + 2][col + 2] == checker and \
                   self.slots[row + 3][col + 3] == checker:
                    return True
        return False

    def is_up_diagonal_win(self, checker):
        """Checks for an upward diagonal win for the specified checker."""
        for row in range(3, self.height):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row - 1][col + 1] == checker and \
                   self.slots[row - 2][col + 2] == checker and \
                   self.slots[row - 3][col + 3] == checker:
                    return True
        return False




#Player class
class Player:
    def __init__(self,checker):
        """constructer for player"""
        assert(checker == 'X' or checker == 'O')
        self.checker=checker
        self.num_moves=0
    def __repr__(self):
        """Represent player's name"""
        s= 'Player' + " "+ str(self.checker)
        return s
    def opponent_checker(self):
        """returns the players checker"""
        if self.checker=='X':
            return'O'
        if self.checker=='O':
            return "X"
    def next_move(self, b):
        """return the player's next move"""
        self.num_moves+=1
        while True:
            col=int(input('Enter a column: '))
            if 0<=col<=6:
                return col
            else:
                print('Try Again!')
        
 

def connect_four(p1, p2):
    """ Plays a game of Connect Four between the two specified players,
        and returns the Board object as it looks at the end of the game.
        inputs: p1 and p2 are objects representing Connect Four
          players (objects of the class Player or a subclass of Player).
          One player should use 'X' checkers and the other player should
          use 'O' checkers.
    """
    # Make sure one player is 'X' and one player is 'O'.
    if p1.checker not in 'XO' or p2.checker not in 'XO' \
       or p1.checker == p2.checker:
        print('need one X player and one O player.')
        return None

    print('Welcome to Connect Four!')
    print()
    b = Board(6, 7)
    print(b)
    
    while True:
        if process_move(p1, b) == True:
            return b

        if process_move(p2, b) == True:
            return b

def process_move(p, b):
    """ takes two parameters: a Player object p for the player whose move is being processed, and a Board object b for the board on which the game is being played.
    returns an output based on the input and returns a string based of it's a win or a tie'
    """

    ##process_move
    print(p,"'s", "turn")
    move_next=p.next_move(b)
    b.add_checker(p.checker,move_next)
    print()
    print(b)
    if b.is_win_for(p.checker):
       print(p,'wins in' ,p.num_moves,'moves')
       print('Congratulations!')
       return True
    elif b.is_full():
       print("It's a Tie!")
       return True
    else:
       return False


class RandomPlayer(Player):
    ##next_move
    def next_move(self, b):
        """
        input: takes in a board
        output: randomly chooses a move to play on the board
        """
        randomlist=[]
        
        for i in range(b.width):
            if b.can_add_to(i)==True:
                randomlist+=[i]
            
        randoming= random.choice(randomlist)
        return randoming
    
import random  
from ps9pr3 import *


#AIPlayer class
class AIPlayer(Player):
    
   def __init__(self, checker, tiebreak, lookahead):
    """ takes in atributes, checker and lookahead and acts like
    a constructer, and constructs checker, tiebreak and lookahead
    """

    assert(checker == 'X' or checker == 'O')
    assert(tiebreak == 'LEFT' or tiebreak == 'RIGHT' or tiebreak == 'RANDOM')
    assert(lookahead >= 0)
    super().__init__(checker)
    self.tiebreak=tiebreak
    self.lookahead=lookahead
    
   def __repr__(self):
       """
       takes i self and makes a string representation of Player
       """
       return "Player " + self.checker+ " "+ "(" + str(self.tiebreak)+ ", " + str(self.lookahead) +")"
   
    
   def max_score_column(self,scores):
      """
      input:scores
      outputs: determines the max score to add to the list and breaks the Tie break
      """
  
       
      list_score=[]
      for i in range(len(scores)):
          if scores[i]==max(scores):
              list_score+=[i]
      if self.tiebreak=='LEFT':
          return list_score[0]
      elif self.tiebreak=='RIGHT':
          return list_score[-1]
      elif self.tiebreak=='RANDOM':
          return random.choice(list_score)
  
   def scores_for(self, b):
       """
       input: takes in a board
       output: iterates the board to set the scores for each columns;
       predicts the opponnents moves and iterate the columns scores based on it
       """
       scores=[50]*b.width
       for col in range(b.width):
           if b.is_full():
               scores[col]=-1
           elif b.is_win_for(self.checker):
               scores[col]=100
           elif b.is_win_for(self.opponent_checker()):
               scores[col]=0
           elif self.lookahead==0:
               scores[col]=50
           else:
               b.add_checker(self.checker, col)
               opponent=AIPlayer(self.opponent_checker(), self.tiebreak, self.lookahead-1)
               opp_scores=opponent.scores_for(b)
               scores[col]= 100 - max(opp_scores)
 
               if max(opp_scores)==100:
                  scores[col]= 0
               elif max(opp_scores)==50:
                   scores[col]=50
               elif max(opp_scores)==0:
                   scores[col]=100
               
              
               b.remove_checker(col)
       return scores
       
   def next_move(self, b):
      """
      Takes in the board object and use max_score_column to 
      put the max for amount from the scores for function
      """
      self.num_moves+=1
      nextmove= self.max_score_column(self.scores_for(b))
      return nextmove
      
     
           
           

      
     

           
           
       
      
     
      
                
             
             
          
       
       
      
    
    
 
    
