defmodule Solution do
  @spec find_words(board :: [[char]], words :: [String.t()]) :: [String.t()]
  def find_words(board, words) do
    # Build a trie from the words
    trie = build_trie(words)
    result = MapSet.new()

    # Explore the board from each cell
    for i <- 0..(length(board) - 1),
        j <- 0..(length(hd(board)) - 1),
        reduce: result do
      acc ->
        dfs(board, trie, i, j, "", acc)
    end
    |> MapSet.to_list()
  end

  # Build a Trie from the list of words
  defp build_trie(words) do
    Enum.reduce(words, %{}, fn word, trie ->
      insert_word(trie, String.graphemes(word))
    end)
  end

  defp insert_word(trie, []), do: Map.put(trie, :end, true)

  defp insert_word(trie, [char | rest]) do
    child = Map.get(trie, char, %{})
    updated_child = insert_word(child, rest)
    Map.put(trie, char, updated_child)
  end

  # Perform DFS with backtracking
  defp dfs(board, trie, i, j, path, result) do
    cond do
      # If out of bounds or visited, stop the DFS
      i < 0 or j < 0 or i >= length(board) or j >= length(hd(board)) or
          Enum.at(Enum.at(board, i), j) == "#" ->
        result

      true ->
        char = Enum.at(Enum.at(board, i), j)
        next_trie = Map.get(trie, char)

        if next_trie == nil do
          result
        else
          # Update path and check if we found a word
          new_path = path <> char
          result =
            if Map.has_key?(next_trie, :end) do
              MapSet.put(result, new_path)
            else
              result
            end

          # Mark as visited
          updated_board = List.update_at(board, i, fn row ->
            List.update_at(row, j, fn _ -> "#" end)
          end)

          # Explore neighbors
          result =
            dfs(updated_board, next_trie, i + 1, j, new_path, result)
            |> dfs(updated_board, next_trie, i - 1, j, new_path)
            |> dfs(updated_board, next_trie, i, j + 1, new_path)
            |> dfs(updated_board, next_trie, i, j - 1, new_path)

          result
        end
    end
  end
end
