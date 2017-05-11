/*
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

DNA_strand ("ATTGC") # return "TAACG"

DNA_strand ("GTAT") # return "CATA"
*/

public class DnaStrand {
  public static String makeComplement(String dna) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dna.length(); i++) {
      switch (dna.charAt(i)) {
        case 'A': sb.append("T");
                  break;
        case 'T': sb.append("A");
                  break;
        case 'C': sb.append("G");
                  break;
        case 'G': sb.append("C");
                  break;
        default: break;
      }
    }
    return sb.toString();
  }
}
