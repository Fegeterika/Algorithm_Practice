package main

import (
	"fmt"
	"strings"
	"io/ioutil"
	"os"
	"math/rand"
	"time"
)

type deck []string

func newDeck() deck {

	cards := deck{}

	cardSuits := [4]string{"Spades", "Hearts", "Diamonds", "Clubs"}
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

func (d deck) shuffle() {

	// Seed Rand
	source := rand.NewSource(time.Now().UnixNano())
	r := rand.New(source)

	for i, _ := range d {
		newPosition := r.Intn(len(d))
		d[i], d[newPosition] = d[newPosition], d[i]
	}
}

func (d deck) serialize() string {
	return strings.Join([]string(d), ",")
}

func (d *deck) writeToFile(fileName string) error {
	serializedDeck := d.serialize()
	return ioutil.WriteFile(fileName, []byte(serializedDeck), 0666)
}

func newDeckFromFile(filename string) deck {
	bs, err := ioutil.ReadFile(filename)
	if err != nil {
		fmt.Println("Error:", err)
		os.Exit(1)
	}

	return deck(strings.Split(string(bs), ","))
}

func deal(d deck, handSize int) (deck, deck) {
	return d[:handSize], d[handSize:]
}