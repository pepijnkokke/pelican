#!/bin/bash

SEMANTE_HOME="$HOME/.semante"

# Install build-essential
apt-get update
apt-get upgrade
apt-get install build-essential

# Install Prover9
wget http://www.cs.unm.edu/~mccune/mace4/download/LADR-2009-11A.tar.gz
tar xvfz LADR-2009-11A.tar.gz > /dev/null
cd LADR-2009-11A/provers.src
make all >/dev/null
if [ $? -eq 0 ]; then
    echo "Prover9 was built successfully"
else
    echo "Prover9 failed to build"
    exit 1
fi
mkdir -p "${SEMANTE_HOME}/ladr"
mv ../bin/* "${SEMANTE_HOME}/ladr"
ls "${SEMANTE_HOME}/ladr"
cd ../..

# Install Lexicon
mv ./lexicon/src/main/resources/default.lex "${SEMANTE_HOME}/default.lexicon"

# Install Buildr
gem install buildr --no-ri --no-rdoc > /dev/null
echo "Buildr was built successfully"

# Configure SemAnTE
cat << 'EOF' > "${SEMANTE_HOME}/settings.yml"
SemAnTE:
  Lexicon:
    Default:  '${SEMANTE_HOME}/default.lexicon'
  Prover:
    Location: '${SEMANTE_HOME}/ladr'
EOF

# Build Pelican Dependencies
buildr install-deps > /dev/null
