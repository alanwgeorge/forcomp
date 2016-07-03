(0 to 4).map(_ * 5)

for {
  i <- 1 to 5
  j <- 1 to 5
//  if i * 5 + j < 21
} yield ((i * 5 + j) % 7) + 1

for {
  i <- 1 to 5
  j <- 1 to 5
  if (i - 1) * 5 + (j - 1) < 21
} yield (((i - 1) * 5 + (j - 1)) % 7) + 1
