package main

import "fmt"

func main() {
	myDeck := newDeckFromFile("output")
	myDeck.print()

	fmt.Println("\nShuffle now")
	myDeck.shuffle()

	myDeck.print()

	err := myDeck.writeToFile("output")
	if err == nil {
		fmt.Println("No Error")
	} else {
		fmt.Println(err)
	}
}