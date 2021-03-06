module Paths_lex2tex (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
catchIO = Exception.catch


version :: Version
version = Version {versionBranch = [0,1,0,0], versionTags = []}
bindir, libdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/Users/pepijn/Library/Haskell/ghc-7.6.3/lib/lex2tex-0.1.0.0/bin"
libdir     = "/Users/pepijn/Library/Haskell/ghc-7.6.3/lib/lex2tex-0.1.0.0/lib"
datadir    = "/Users/pepijn/Library/Haskell/ghc-7.6.3/lib/lex2tex-0.1.0.0/share"
libexecdir = "/Users/pepijn/Library/Haskell/ghc-7.6.3/lib/lex2tex-0.1.0.0/libexec"
sysconfdir = "/Users/pepijn/Library/Haskell/ghc-7.6.3/lib/lex2tex-0.1.0.0/etc"

getBinDir, getLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "lex2tex_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "lex2tex_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "lex2tex_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "lex2tex_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "lex2tex_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
