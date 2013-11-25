#!/bin/bash

SEMANTE_HOME="$HOME/.semante"

# Install Prover9
wget http://www.cs.unm.edu/~mccune/mace4/download/LADR-2009-11A.tar.gz
tar xvfz LADR-2009-11A.tar.gz >/dev/null
cd LADR-2009-11A
patch ./provers.src/Makefile ../Makefile.patch
make all >/dev/null
if [ $? -eq 0 ]; then
    echo "Prover9 was built successfully"
else
    echo "Prover9 failed to build"
    exit 1
fi
mkdir -p "${SEMANTE_HOME}/ladr"
mv ./bin/* "${SEMANTE_HOME}/ladr"
ls "${SEMANTE_HOME}/ladr"
cd ..

# Install Lexicon
cp -f ./lexicon/src/main/resources/default.lexicon "${SEMANTE_HOME}/default.lexicon"
cp -f ./lexicon/src/main/resources/legacy.lexicon "${SEMANTE_HOME}/legacy.lexicon"

# Configure SemAnTE
cat <<EOF > "${SEMANTE_HOME}/default.yml"
SemAnTE:
  Lexicon:
    Default:  '${SEMANTE_HOME}/default.lexicon'
  Prover:
    Location: '${SEMANTE_HOME}/ladr'
EOF
cat <<EOF > "${SEMANTE_HOME}/legacy.yml"
SemAnTE:
  Lexicon:
    Default:  '${SEMANTE_HOME}/legacy.lexicon'
  Prover:
    Location: '${SEMANTE_HOME}/ladr'
EOF
