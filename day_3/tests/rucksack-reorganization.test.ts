import { expect } from "chai";
import { sumOfPriotitesItemsInRucksack } from "../src/rucksack-reorganization"

describe('should count sum of the priorities of item types', function () {
    let input = [
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"
    ]
    it('add', function () {
        let result = sumOfPriotitesItemsInRucksack(input)

        expect(result).equal(157);
    });
});