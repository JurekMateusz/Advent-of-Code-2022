const fs = require('fs');
import { sumOfPriotitesItemsInRucksack } from "./rucksack-reorganization"

let inputFileName: String = "../../input.txt"
let result: String[] = fs.readFileSync(__dirname + '/' + inputFileName).toString().split("\n")
console.log(sumOfPriotitesItemsInRucksack(result))