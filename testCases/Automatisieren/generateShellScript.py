# Automatic calling all the necessary Files to test all test cases.

n = input("# How many test cases?\n")
fileShellScript = open("shellScript.sh","w")

def copyAllTheThings(n):
	inc = 1
	temp = n
	fileShellScript.write("clear\n")
	fileShellScript.write("echo \"\"######################## Starting Shell Script \"########################\"\n")
	fileShellScript.write("echo \"# Compiling all *.java Files...\"\n")
	fileShellScript.write("javac *.java\n")
	fileShellScript.write("echo \"# Preparing directory...\"\n")
	fileShellScript.write("mkdir tests\n")
	while temp != 0:
		fileShellScript.write("cp testCases/"+str(inc)+".pas tests/\n")
		inc += 1
		temp -= 1

def createShellScript(n):
	inc = 1
	temp = n
	while temp != 0:
		fileShellScript.write("echo \"######################## Test " + str(inc) + " ########################\"\n")
		fileShellScript.write("echo \"# Calling StupsCompiler...\"\n")
		fileShellScript.write("java StupsCompiler -compile tests/"+str(inc)+".pas\n")
		fileShellScript.write("echo \"# Calling jasmin.jar...\"\n")
		fileShellScript.write("java -jar jasmin.jar tests/"+str(inc)+".j\n")
		fileShellScript.write("echo \"# Executing Java File...\"\n")
		fileShellScript.write("java tests/"+str(inc)+"\n")
		fileShellScript.write("echo \"# Done.\"\n")
		inc += 1
		temp -= 1

# Main Program
copyAllTheThings(n)
createShellScript(n)
print "# Great! Now execute:"
print "# > sh shellScript.sh"