/**
 * Computes a scaled maximum product based on the two largest absolute values in an integer array.
 *
 * <p>This method scans the input array once, tracking the largest ({@code max1}) and second-largest
 * ({@code max2}) values after converting each element to its absolute value. It then returns
 * {@code max1 * max2 * 100000L} as a {@code long}.</p>
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Initialize {@code max1} and {@code max2} to 0.</li>
 *   <li>For each element {@code n} in {@code nums}:
 *     <ul>
 *       <li>Replace {@code n} with {@code abs(n)}.</li>
 *       <li>If {@code n > max1}: shift {@code max1} into {@code max2}, then set {@code max1 = n}.</li>
 *       <li>Else if {@code n > max2}: set {@code max2 = n}.</li>
 *     </ul>
 *   </li>
 *   <li>Return {@code max1 * max2 * 100000L}.</li>
 * </ol>
 *
 * <h2>Notes and edge cases</h2>
 * <ul>
 *   <li>If {@code nums} has fewer than two elements, or if all absolute values are 0, the result may be 0
 *       because {@code max1} and/or {@code max2} will remain 0.</li>
 *   <li>This uses absolute values, so negative numbers contribute by magnitude (e.g., -7 is treated as 7).</li>
 *   <li>{@code Math.abs(Integer.MIN_VALUE)} overflows and returns {@code Integer.MIN_VALUE} (still negative),
 *       which may affect correctness for that specific value.</li>
 *   <li>The result is computed in {@code long} to reduce overflow risk, but extremely large inputs can still
 *       overflow {@code long} after multiplication.</li>
 * </ul>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time: O(n) — single pass through the array.</li>
 *   <li>Space: O(1) — constant extra storage.</li>
 * </ul>
 *
 * @param nums the input array of integers
 * @return the product of the two largest absolute values in {@code nums}, multiplied by {@code 100000}
 */