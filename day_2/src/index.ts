const fs = require('fs');
import { mapToArg, Arg } from './mapping-args'
import { checkRoundResult, RoundResult, countPoints } from './game-rulles'




let inputFileName: String = "../input.txt"
let elfData: String[] = fs.readFileSync(__dirname + '/' + inputFileName).toString().split("\n")

let result = elfData
    .map(line => mapToArg(line))
    .map(args => {
        let result: RoundResult = checkRoundResult(args.yourMove, args.moveOfOpponent);
        return { args, result }
    }
    )
    .map(result => countPoints(result.args, result.result))
    .reduce((accumulator, currentValue) => accumulator + currentValue, 0)

console.log(result)



let createReader = (fileName: string | String) => require('readline').createInterface({
    input: fs.createReadStream(__dirname + '/' + fileName),
    crlfDelay: Infinity
});



