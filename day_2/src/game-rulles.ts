import { Arg } from "./mapping-args"
export enum GameMove {
    PAPER, ROCK, SCISSORS
}
export enum RoundResult {
    WIN, DRAW, DEFEAT
}
let defeatMap = new Map<GameMove, GameMove>([
    [GameMove.PAPER, GameMove.ROCK],
    [GameMove.SCISSORS, GameMove.PAPER],
    [GameMove.ROCK, GameMove.SCISSORS]
])
let choosePoints = new Map<GameMove, number>([
    [GameMove.ROCK, 1],
    [GameMove.PAPER, 2],
    [GameMove.SCISSORS, 3],
])
let winPoints = new Map<RoundResult, number>([
    [RoundResult.WIN, 6],
    [RoundResult.DRAW, 3],
    [RoundResult.DEFEAT, 0],
])
export let checkRoundResult = (move1: GameMove, move2: GameMove): RoundResult => {
    if (move1 == move2) {
        return RoundResult.DRAW
    }
    let defeats = defeatMap.get(move1)
    if (defeats == move2) {
        return RoundResult.WIN
    }
    return RoundResult.DEFEAT
}

export let countPoints = (arg: Arg, result: RoundResult): number => {
    let chooseResult = choosePoints.get(arg.yourMove)
    let winPoint = winPoints.get(result)
    return (chooseResult ?? 0) + (winPoint ?? 0)
}

// PAPPER - Y  B
//  ROCK - X A
// SCIZORS - Z C

//C X 6 + 1 = 7 
//B Z 6 + 3 = 9 

