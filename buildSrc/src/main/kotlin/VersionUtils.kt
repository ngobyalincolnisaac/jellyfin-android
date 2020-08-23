/**
 * Get the version code for a given semantic version.
 * Does not validate the input and thus will throw an exception when parts are missing.
 *
 * The pre-release part ("-rc.1", "-beta.1" etc.) defaults to 99
 *
 * Sample output:
 * MA.MI.PA-PR   -> MAMIPAPR
 * 0.0.0         ->       99
 * 1.1.1         ->  1010199
 * 0.7.0         ->    70099
 * 99.99.99      -> 99999999
 * 2.0.0-rc.3    ->  2000003
 * 2.0.0         ->  2000099
 * 99.99.99-rc.1 -> 99999901
 */
fun getVersionCode(versionName: String): Int? {
    // Split to core and pre release parts with a default for pre release (null)
    val (versionCore, versionPreRelease) = versionName
        .split("-", limit = 2)
        .let {
            when (it.size) {
                // No pre release part included
                1 -> arrayOf(it[0], null)
                // Pre release part included
                else -> arrayOf(it[0], it[1])
            }
        }

    // Parse core part
    val (major, minor, patch) = versionCore!!
        .splitToSequence('.')
        .mapNotNull(String::toIntOrNull)
        .take(3)
        .toList()

    // Parse pre release part (ignore type, only get the number)
    val buildVersion = versionPreRelease
        ?.split('.', limit = 2)
        ?.getOrNull(1)
        ?.let(String::toIntOrNull)

    // Build code
    var code = 0
    code += major * 1000000 // Major (0-99)
    code += minor * 10000 // Minor (0-99)
    code += patch * 100 // Patch (0-99)
    code += buildVersion ?: 99 // Pre release (0-99)

    return code
}
