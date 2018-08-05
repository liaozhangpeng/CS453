for i in range(1, 24):
    with open("test{}.in".format(i), "r") as f:
        lines = f.readlines()

    line = "".join(lines)
    line = line.replace("TokenMatcher", "json")
    print line
