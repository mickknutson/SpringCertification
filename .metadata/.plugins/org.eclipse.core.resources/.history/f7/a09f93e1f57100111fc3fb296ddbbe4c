public aspect DontWriteToTheConsole {

    pointcut sysOutOrErrAccess() : get(* System.out) || get(* System.err);

    declare error
      : sysOutOrErrAccess()
      : "Don't write to the console";

}