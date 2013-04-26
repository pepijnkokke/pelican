import Base
import StdLib
import Parsing
import Printing

import Data.String.Utils
import Text.ParserCombinators.UU.Utils (runParser)

main :: IO ()
main = getContents >>= print . runParser "StdIn" pLx
