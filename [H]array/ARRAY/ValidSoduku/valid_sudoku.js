var isValidSudoku = function(board) {
    if(!board) return false;


    // WARN: báo như bên dưới. Do hàm fill sẽ tao tạo ra 9 phần từ cùng thàm chiếu đến một đối tượng Set
    // let rows = Array(9).fill(new Set());
    // let cols = Array(9).fill(new Set());
    // let squares = Array(9).fill(new Set());


    let rows = Array.from({ length: 9 }, () => new Set());
    let cols = Array.from({ length: 9 }, () => new Set());
    let squares = Array.from({ length: 9 }, () => new Set());

    for(let r = 0; r < 9; r++) {
        for(let c = 0; c < 9; c++) {
            if(board[r][c] === '.') continue

            const value = board[r][c]
            const squareKey = Math.floor(r / 3) * 3 + Math.floor(c / 3)

            if(rows[r].has(value) || cols[c].has(value) || squares[squareKey].has(value)) {return false} 

            rows[r].add(value) 
            cols[c].add(value) 
            squares[squareKey].add(value)
        }
    }

    return true

};


const board = [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]

const board2 = [["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]

console.log(isValidSudoku(board), isValidSudoku(board2))
