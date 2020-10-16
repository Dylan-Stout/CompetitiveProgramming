
"""
https://leetcode.com/problems/queens-that-can-attack-the-king/

On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.

Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
Explanation:
The queen at [0,1] can attack the king cause they're in the same row.
The queen at [1,0] can attack the king cause they're in the same column.
The queen at [3,3] can attack the king cause they're in the same diagnal.
The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.


Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
Output: [[2,2],[3,4],[4,4]]


Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]

TODO: Needs check for recursive knight moves


"""
class Solution(object):
    def queensAttacktheKing(self, queens, king):
        """
        :type queens: List[List[int]]
        :type king: List[int]
        :rtype: List[List[int]]
        """
        result = []
        self.queens = queens
        for queen in queens:
            can_kill_king = self.check_able_to_kill_king(queen, king)
            if can_kill_king:
                result.append(queen)
        return result

    def check_able_to_kill_king(self,queen, king):
        is_able = self.check_row(queen, king)
        if not is_able:
            is_able = self.check_column(queen, king)
        if not is_able:
            is_able = self.check_diagonal(queen, king)
        if not is_able:
            is_able = self.check_knight_move(queen, king)
        return is_able

    def check_row(self, queen, king):
        is_king_attackable = False
        # determine if king is in row first
        if king[0] == queen[0]:
            # if king in row check against other queens to see if blocked
            is_blocked = False
            for other_queen in self.queens:
                if other_queen[0] == queen[0]:
                    if king[0] < queen[0] and other_queen[0] < queen[0]:
                        is_blocked = True
                    if (king[0] > queen[0]) and (other_queen[0] > queen[0]):
                        is_blocked = True
            if not is_blocked:
                is_king_attackable = True
        return is_king_attackable

    def check_column(self, queen, king):
        is_king_attackable = False
        # determine if king is in col first
        if king[1] == queen[1]:
            # if king in col check against other queens to see if blocked
            is_blocked = False
            for other_queen in self.queens:
                if other_queen[1] == queen[1]:
                    if king[1] < queen[1] and other_queen[1] < queen[1]:
                        is_blocked = True
                    if king[1] > queen[1] and other_queen[1] > queen[1]:
                        is_blocked = True
            if not is_blocked:
                is_king_attackable = True

        return is_king_attackable

    def check_diagonal(self, queen, king):
        # determine if king is in diagonal
        is_king_up_to_right = self.check_king_diagonal_recursively_right_up(queen[0], queen[1], king)
        is_king_up_to_left = self.check_king_diagonal_recursively_left_up(queen[0], queen[1], king)
        is_king_down_to_right = self.check_king_diagonal_recursively_right_down(queen[0], queen[1], king)
        is_king_down_to_left = self.check_king_diagonal_recursively_left_down(queen[0], queen[1], king)
        if is_king_up_to_right or is_king_up_to_left or is_king_down_to_right  or is_king_down_to_left:
            # if king in diagonal check against other queens to see if blocked
            if is_king_up_to_right:
                for other_queen in self.queens:
                    is_queen_blocking = self.check_king_diagonal_recursively_right_up(queen[0], queen[1], other_queen)
                    if is_queen_blocking:
                        return False
                return True
            if is_king_down_to_right:
                for other_queen in self.queens:
                    is_queen_blocking = self.check_king_diagonal_recursively_right_down(queen[0], queen[1], other_queen)
                    if is_queen_blocking:
                        return False
                return True
            if is_king_up_to_left:
                for other_queen in self.queens:
                    is_queen_blocking = self.check_king_diagonal_recursively_left_up(queen[0], queen[1], other_queen)
                    if is_queen_blocking:
                        return False
                return True
            if is_king_down_to_left:
                for other_queen in self.queens:
                    is_queen_blocking = self.check_king_diagonal_recursively_left_down(queen[0], queen[1], other_queen)
                    if is_queen_blocking:
                        return False
                return True
        return False

    def check_king_diagonal_recursively_right_up(self, row, col, king):
        if row > 8 or col > 8:
            return False
        if row < 0 or col < 0:
            return False

        if king[0] == row and king[1] == col:
            return True
        else:
            self.check_king_diagonal_recursively_right_up(row - 1, col + 1, king)

    def check_king_diagonal_recursively_right_down(self, row, col, king):
        if row > 8 or col > 8:
            return False
        if row < 0 or col < 0:
            return False

        if king[0] == row and king[1] == col:
            return True
        else:
            self.check_king_diagonal_recursively_right_down(row + 1, col + 1, king)

    def check_king_diagonal_recursively_left_up(self, row, col, king):
        if row > 8 or col > 8:
            return False
        if row < 0 or col < 0:
            return False

        if king[0] == row and king[1] == col:
            return True
        else:
            self.check_king_diagonal_recursively_left_up(row - 1, col - 1, king)

    def check_king_diagonal_recursively_left_down(self, row, col, king):
        if row > 8 or col > 8:
            return False
        if row < 0 or col < 0:
            return False
        if king[0] == row and king[1] == col:
            return True
        else:
            self.check_king_diagonal_recursively_left_down(row + 1, col - 1, king)


# determin if king in knight move
# if king in knight move check against other queens to see if blocked

