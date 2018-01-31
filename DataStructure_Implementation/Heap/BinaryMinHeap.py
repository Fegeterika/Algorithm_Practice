class BinMinHeap:

	def __init__(self):
		""" Make first element in an empty heap 0 to simplify some operations simpler """
		self.heapList = [0]
		self.curSize = 0

	def insert(self, *vals):
		""" Just append item to the end and swap position with parents """
		for val in vals:
			self.heapList.append(val)
			self.curSize += 1
			self.percUp(self.curSize)

	def buildHeap(self, val_list):
		self.curSize = len(val_list)
		self.heapList = [0] + val_list[:]
		# percDown from minimum node n / 2 times (in binary tree, nodes below half way are leaves)
		i = self.curSize // 2
		while (i > 0):
			self.percDown(i)
			i -= 1

	def delMin(self):
		""" Remove the first item and move last item to the first position. Then, perc down """
		res = self.heapList[1]
		self.heapList[1] = self.heapList[self.curSize]
		self.curSize -= 1
		self.heapList.pop()
		self.percDown(1)
		return res

	def percUp(self, i):
		while (i > 1):
			if self.heapList[i] < self.heapList[i // 2]:
				temp = self.heapList[i // 2]
				self.heapList[i // 2] = self.heapList[i]
				self.heapList[i] = temp
			i = i // 2

	def percDown(self, i):
		# percDown only if node has at least one child
		while (i * 2 <= self.curSize):
			target = self.findMinChild(i)
			if self.heapList[i] > self.heapList[target]:
				temp = self.heapList[target]
				self.heapList[target] = self.heapList[i]
				self.heapList[i] = temp
			i = target

	def findMinChild(self, i):
		# return first child if second child does not exist
		if i * 2 + 1 > self.curSize:
			return i * 2
		else:
			if self.heapList[i * 2] < self.heapList[i * 2 + 1]:
				return i * 2
			else:
				return i * 2 + 1

if __name__ == "__main__":
	minHeap = BinMinHeap()
	minHeap.insert(8, 2, 3, 4, 7)
	print(minHeap.heapList)

	minHeap.delMin()
	print(minHeap.heapList)

	minHeap.buildHeap([8, 2, 3, 4, 7])
	print(minHeap.heapList)
