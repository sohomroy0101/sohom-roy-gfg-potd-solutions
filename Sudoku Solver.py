# Leetcode Problem 37: Sudoku Solver
# PYTHON CODE
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        def isValid(row, col, num):
            for i in range(9):
                if board[row][i] == num:
                    return False
                if board[i][col] == num:
                    return False

                r = 3 * (row // 3) + i // 3
                c = 3 * (col // 3) + i % 3

                if board[r][c] == num:
                    return False

            return True

        def solve():
            for row in range(9):
                for col in range(9):
                    if board[row][col] == '.':
                        for num in map(str, range(1, 10)):
                            if isValid(row, col, num):
                                board[row][col] = num

                                if solve():
                                    return True

                                board[row][col] = '.'
                        return False
            return True

        solve()