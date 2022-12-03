let devidePerCompartments = (rucksack: String): [String, String] => {
    let size = rucksack.length
    if (size % 2 == 1) {
        throw new Error("Wrong size of rucksack")
    }
    let firstCompartment = rucksack.substring(0, size / 2 )
    let secCompartment = rucksack.substring(size / 2 )
    return [firstCompartment, secCompartment]
}
let findDuplicates = (compartments: [String, String]): String => {
    let createSet = (letters: String) => new Set(letters.split(""))
    let con1 = createSet(compartments[0])
    let con2 = createSet(compartments[1])
    return [...con1]
        .filter(type => con2.has(type))[0]
}
let prioritiesItems = (type: String): number => {
    let valType = type.charCodeAt(0);
    if (valType >= 97 && valType <= 122) {
        return valType - 96
    }
    if (valType >= 65 && valType <= 90) {
        return valType - 38
    }
    throw new Error("Wrong Type: " + type)
}

export function sumOfPriotitesItemsInRucksack(input: String[]): number {
    return input
        .map(ruckSackItems => ruckSackItems.trim())
        .map(rucksackItems => devidePerCompartments(rucksackItems))
        .map(compartments => findDuplicates(compartments))
        .map(duplicates => prioritiesItems(duplicates))
        .reduce((acc, curr) => acc + curr, 0)
}