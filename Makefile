JFLAGS = -g
JC = javac

TARGET = TestSimpleGraph Main

target: $(TARGET)

$(TARGET): $(TARGET).java
	$(JC) $(JFLAGS) $(TARGET).java


#all: TestSimpleGraph
	#$(JC) $(JFLAGS) $*.java

clean: 
	$(RM) *.class
