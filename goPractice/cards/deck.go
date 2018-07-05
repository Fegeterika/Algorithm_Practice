package main

import "fmt"

type deck []string

func newDeck() deck {

	cards := deck{}

	cardSuits := [4]string{"Spaces", "Hearts", "Diamonds", "Clubs"}
	cardValues := [13]string{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"}

	for _, suit := range cardSuits {
		for _, value := range cardValues {
			cards = append(cards, value + " of " + suit)
		}
	}

	return cards
}

func (d *deck) print() {
	for i, card := range *d {
		fmt.Println(i, card)
	}
}

func (d *deck) 