SRC_DIR= src/avajlauncher
OUT_DIR= target

SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSES := $(patsubst $(SRC_DIR)/%.java,$(OUT_DIR)/%.class,$(SOURCES))

all: compile

compile: $(OUT_DIR) $(CLASSES)

$(OUT_DIR):
	@mkdir -p $(OUT_DIR)

$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	@javac -d $(OUT_DIR) $(SOURCES)

run:
	@if [ -z "$(ARG)" ]; then \
		echo "Usage: make run ARG=argument.txt"; \
		exit 1; \
	fi
	@java -cp $(OUT_DIR) avajlauncher.Main $(ARG)

clean:
	@rm -rf $(OUT_DIR)
	@rm -f simulation.txt

fclean: clean

re: clean all

.PHONY: all compile clean fclean re