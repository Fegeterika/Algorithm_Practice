package main

import (
	"fmt"
	"testing"
	"os"
)

func TestNewDeck(t *testing.T) {
	d := newDeck()

	if len(d) != 52 {
		t.Errorf("Expected deck length is 52, but got %v", len(d))
	}

	if d[0] != "Ace of Spades" {
		t.Errorf("Expected Ace of Spades, but got %s", d[0])
	}
}

func TestSaveToDeckAndNewDeckTestFromFile(t *testing.T) {
	err := os.Remove("_decktesting")
	if err != nil {
		fmt.Println("File removal error:", err)
	}

	d := newDeck()
	d.writeToFile("_decktesting")

	loadedDeck := newDeckFromFile("_decktesting")

	if len(loadedDeck) != 52 {
		t.Errorf("Expected deck length is 52, but got %v", len(loadedDeck))
	}

	os.Remove("_decktesting")
}