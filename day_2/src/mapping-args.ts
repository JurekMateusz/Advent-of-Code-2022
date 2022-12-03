import { GameMove } from "./game-rulles";

export function mapToArg(line: String): Arg {
    const args = line.trim().split(" ")
    if (args.length != 2) {
        throw new Error('Wrong input');
    }
    return new Arg(mapOpponentMove(args[0]), mapYourMove(args[1]))
}

export class Arg {
    moveOfOpponent: GameMove
    yourMove: GameMove

    public constructor(moveOfOpponent: GameMove, yourMove: GameMove) {
        this.moveOfOpponent = moveOfOpponent
        this.yourMove = yourMove
    }
}


function mapOpponentMove(move: String): GameMove {
    switch (move) {
        case "A":
            return GameMove.ROCK
        case "B":
            return GameMove.PAPER
        case "C":
            return GameMove.SCISSORS
    }
    throw new Error("Wrong input: "+ move)
}

function mapYourMove(move: String): GameMove {
    switch (move) {
        case "X":
            return GameMove.ROCK
        case "Y":
            return GameMove.PAPER
        case "Z":
            return GameMove.SCISSORS
    }
    throw new Error("Wrong input: "+ move)
}