package main

import (
	"fmt"
	"log"
)

func day7() {
	lines, err := readLines("input/day7.txt")
	if err != nil {
		log.Fatalf("readLines: %s", err)
	}
	for i, line := range lines {
		fmt.Println(i, line)
	}
}
