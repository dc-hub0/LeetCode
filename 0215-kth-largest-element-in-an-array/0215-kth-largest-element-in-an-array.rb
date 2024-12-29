require 'heap'

def find_kth_largest(nums, k)
  # Create a min-heap from the first 'k' elements of the array
  min_heap = nums[0...k]
  Heapify(min_heap)

  # Iterate over the remaining elements in the array
  nums[k..-1].each do |num|
    # If the current number is greater than the smallest in the heap, replace it
    if num > min_heap[0]
      min_heap.pop
      min_heap.push(num)
      Heapify(min_heap)
    end
  end

  # The root of the heap is the kth largest element
  min_heap[0]
end

# Helper method to turn an array into a min-heap
def Heapify(array)
  array.sort!
end
